package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.infra.error.exception.UserNotFoundException;
import project.nftshop.infra.error.exception.WrongPasswordException;
import project.nftshop.persistence.entity.*;
import project.nftshop.persistence.repository.OrderProductRepository;
import project.nftshop.persistence.repository.OrderRepository;
import project.nftshop.persistence.repository.ProductRepository;
import project.nftshop.persistence.repository.UserRepository;
import project.nftshop.service.model.mapper.OrderMapper;
import project.nftshop.service.model.mapper.OrderProductMapper;
import project.nftshop.service.model.request.OrderReqDtos;
import project.nftshop.service.model.response.OrderResDtos;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    /**
     * 웹툰 소재를 구현하는 것이기 때문에 삭제, 수정 서비스는 필요 X
     * 대신 한 번 구매하면 환불하지 못한다는 디자인이 필요하다 생각
     * */
    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final OrderMapper orderMapper;

    private final OrderProductMapper orderProductMapper;

    private final OrderProductRepository orderProductRepository;


    /**
     * createOrder service
     * jwt 구현하지 못해서 로그인 체크를 한 번 더함.
     * 다대다 구현 후 product를 List로 받아야하지 않을까? 의문
     * product의 데이터가 없어서 테스트 x
     * */
    //내가 등록한 상품이면 exception
    @Transactional
    public void createOrder(OrderReqDtos.CREATE create){

        final User user = userRepository.findByIdentity(create.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        LocalDate paymentDate = LocalDate.now();

        Order order = orderMapper.toOrderEntity(create, user, paymentDate, Collections.emptyList(), 0);

        final List<OrderProduct> orderProducts = getOrderProduct(create.getProductsName(), order);

        order.updateOrderProducts(orderProducts);

        Set<Product> products = getProductsName(create.getProductsName()); //{test1, test2}
        int totalPrice = products.stream().mapToInt(Product::getPrice).sum();

        products.forEach(Product::incrementQuantitySale);

        order.updateTotalPrice(totalPrice);

        orderProductRepository.saveAll(orderProducts);

        orderRepository.save(order);
    }

//    public List<OrderResDtos.READ> readOrderInfo(String identity){
//
//        final Order order = orderRepository.findByUsersIdentity(identity)
//                .orElseThrow(() -> new NotFoundException());
//
//        final List<String> productsName = getProductsNameByOrder(order);
//
//        return orderMapper.toReadDto(order, productsName);
//    }

//    public List<OrderResDtos.READ> readOrderInfo(String identity){
//
//        List<Order> order = orderRepository.findByUsersIdentity(identity);
//
//       // final List<String> productsName = getProductsNameByOrder(order);
//        List<String> productsName = getProductsNameByOrder(order.)
//        return orderMapper.toReadDto(order, productsName);
//    }
//
//    private List<String> getProductsNameByOrder(Order order){
//
//        return order.getOrderProducts()
//                .stream()
//                .map(OrderProduct::getProduct)
//                .map(Product::getProductsNames)
//                .collect(Collectors.toList());
//    }
    public List<OrderResDtos.READ> readOrderInfo(String identity) {
        List<Order> orders = orderRepository.findByUsersIdentity(identity);
        List<OrderResDtos.READ> result = new ArrayList<>();

        for (Order order : orders) {
            List<String> productsNames = getProductsNameByOrder(order);
            List<String> saveNames = getSaveNameByOrder(order);
            result.add(orderMapper.toReadDto(order, productsNames, saveNames));
        }

        return result;
    }


    private List<String> getProductsNameByOrder(Order order){
        return order.getOrderProducts()
                .stream()
                .map(OrderProduct::getProduct)
                .map(Product::getProductsNames)
                .collect(Collectors.toList());
    }

    private List<String> getSaveNameByOrder(Order order){
        return order.getOrderProducts()
                .stream()
                .map(OrderProduct::getProduct)
                .map(Product::getImageFile)
                .map(ImageFile::getSaveName)
                .collect(Collectors.toList());
    }



    private List<OrderProduct> getOrderProduct(Set<String> productsName,
                                                      Order order){

        final Set<Product> products = getProductsName(productsName); //이름 잘 들어옴

        return products.stream()
                .map(product -> orderProductMapper.toOrderProductEntity(product, order))
                .collect(Collectors.toList());
    }

    /**
     * 상품 이름 가져오기 메소드
     * */
    private Set<Product> getProductsName(Set<String> productsName){

        List<Product> products = productRepository.findAllByProductsNamesIn(productsName); //오류발생
        //이름 잘 들어옴.
        return new HashSet<>(products);
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }
}
