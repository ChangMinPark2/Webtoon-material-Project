package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.OrderReqDtos;
import project.nftshop.service.service.OrderService;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseFormat createOrder(@RequestBody @Valid OrderReqDtos.CREATE create){
        orderService.createOrder(create);
        return ResponseFormat.ok();
    }
}
