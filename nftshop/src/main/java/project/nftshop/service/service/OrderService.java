package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.infra.error.exception.UserNotFoundException;
import project.nftshop.infra.error.exception.WrongPasswordException;
import project.nftshop.infra.error.model.ErrorCode;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.entity.User;
import project.nftshop.persistence.repository.OrderRepository;
import project.nftshop.persistence.repository.ProductsRepository;
import project.nftshop.persistence.repository.UserRepository;
import project.nftshop.service.model.request.OrderReqDtos;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

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

    private final ProductsRepository productsRepository;

    /**
     * createOrder service
     * jwt 구현하지 못해서 로그인 체크를 한 번 더함.
     * 다대다 구현 후 product를 List로 받아야하지 않을까? 의문
     * product의 데이터가 없어서 테스트 x
     * */
    @Transactional
    public void createOrder(OrderReqDtos.CREATE create){

        final User user = userRepository.findByIdentity(create.getIdentity())
                .orElseThrow(() -> new UserNotFoundException());

        checkPassword(user.getPassword(), create.getPassword());

        final Product product = productsRepository.findByName(create.getProductName())
                        .orElseThrow(() -> new NotFoundException());

        product.incrementQuantitySale(); // 판매수량 + 1

        LocalDate date = LocalDate.now(); // 현재날짜

        orderRepository.save(Order.toOrderCreate(create, user, date, product));
    }

    private void checkPassword(String password, String checkPassword){
        if(!password.equals(checkPassword))
            throw new WrongPasswordException();
    }
}
