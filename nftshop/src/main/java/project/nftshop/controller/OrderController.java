package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.nftshop.infra.error.model.ErrorCodeType;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.OrderReqDtos;
import project.nftshop.service.model.response.OrderResDtos;
import project.nftshop.service.service.OrderService;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseFormat createOrder(@RequestBody @Valid OrderReqDtos.CREATE create){
        orderService.createOrder(create);
        return ResponseFormat.ok();
    }

    @GetMapping
    public ResponseFormat<OrderResDtos.READ> readOrder(@RequestParam(name = "identity") String identity){
        return ResponseFormat.ok(orderService.readOrderInfo(identity));
    }
}
