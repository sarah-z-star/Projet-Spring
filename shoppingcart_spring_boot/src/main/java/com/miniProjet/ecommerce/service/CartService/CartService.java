package com.miniProjet.ecommerce.service.CartService;

import java.util.List;

import com.miniProjet.ecommerce.model.AddtoCart;
import com.miniProjet.ecommerce.model.CheckoutCart;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
	List<AddtoCart> addCartbyUserIdAndProductId(long productId, long userId, int qty, double price) throws Exception;
	void updateQtyByCartId(long cartId,int qty,double price) throws Exception;
	List<AddtoCart> getCartByUserId(long userId);
	List<AddtoCart> removeCartByUserId(long cartId,long userId);
	List<AddtoCart> removeAllCartByUserId(long userId);
	Boolean checkTotalAmountAgainstCart(double totalAmount,long userId);
	List<CheckoutCart> getAllCheckoutByUserId(long userId);
	List<CheckoutCart> saveProductsForCheckout(List<CheckoutCart> tmp)  throws Exception;
	
	
	//CheckOutCart
}
