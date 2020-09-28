package com.example.pizzahut.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzahut.R;
import com.example.pizzahut.model.CartItem;

import java.util.List;

public class Cart extends RecyclerView.Adapter{
    private List<CartItem> cartItemList;

    public Cart(List<CartItem> cartItemList) {
        this.cartItemList = cartItemList;
    }

    @Override
    public int getItemViewType(int position) {
        switch (cartItemList.get(position).getType()){
            case 0:
                return CartItem.CART_ITEM;

            case 1:
                return CartItem.TOTAL_AMOUNT;

            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        switch (viewType){
            case  CartItem.CART_ITEM:
                View cartItemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item_layout,viewGroup,false);
                return new CartItemViewholder(cartItemView);

                case CartItem.TOTAL_AMOUNT:
                    View cartTotalView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_total_amount_layout,viewGroup,false);
                    return new CartItemViewholder(cartTotalView);

            default:
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (cartItemList.get(position).getType()){
            case CartItem.CART_ITEM:
                int resource = cartItemList.get(position).getProductImage();
                String title = cartItemList.get(position).getProductTitle();
                int freeCoupons = cartItemList.get(position).getFreeCoupons();
                String productPrice = cartItemList.get(position).getProductPrice();
                int offerApplied = cartItemList.get(position).getOffersApplied();

                ((CartItemViewholder)holder).setItemDetails(resource,title,freeCoupons,productPrice);
                break;

                case CartItem.TOTAL_AMOUNT:
                    int totalItems = cartItemList.get(position).getTotalItems();
                    String totalItemPrice = cartItemList.get(position).getTotalItemPrice();
                    String deliveryPrice = cartItemList.get(position).getDeliveryPrice();
                    String totalAmount = cartItemList.get(position).getTotalItemPrice();

                    ((CartTotalAmountViewholder)holder).setTotalAmount(totalItems,totalItemPrice,deliveryPrice,totalAmount);
                    break;
            default:
                return;
        }
    }

    @Override
    public int getItemCount() {
        return cartItemList.size();
    }

    class CartItemViewholder extends RecyclerView.ViewHolder{
        private ImageView productImage;
        private TextView productTitle;
        private TextView freeCoupons;
        private TextView productPrice;
        private TextView cuttedPrice;
        private TextView offerApplied;
        private TextView couponApplied;
        private TextView productQuantity;

        public CartItemViewholder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.product_image);
            productTitle = itemView.findViewById(R.id.product_title);
            freeCoupons = itemView.findViewById(R.id.free_coupon_txt);
            offerApplied = itemView.findViewById(R.id.promo_applied);
            productQuantity = itemView.findViewById(R.id.product_quantity);
            productPrice = itemView.findViewById(R.id.product_price);
        }
        private void setItemDetails(int resource,String title,int freeCouponsNo,String productPriceText){
            productImage.setImageResource(resource);
            productTitle.setText(title);

            if (freeCouponsNo >0){
                freeCoupons.setVisibility(View.VISIBLE);
                offerApplied.setVisibility(View.VISIBLE);
            }
            else {
                freeCoupons.setVisibility(View.INVISIBLE);
                offerApplied.setVisibility(View.INVISIBLE);
            }
            productPrice.setText(productPriceText);
        }
    }

    class CartTotalAmountViewholder extends RecyclerView.ViewHolder{

        private TextView totalItems;
        private TextView totalItemPrice;
        private TextView deliveryPrice;
        private TextView totalAmount;

        public CartTotalAmountViewholder(@NonNull View itemView) {
            super(itemView);

            totalItems = itemView.findViewById(R.id.total_items);
            totalItemPrice = itemView.findViewById(R.id.item_price);
            deliveryPrice = itemView.findViewById(R.id.delivery_charge_price);
            totalAmount = itemView.findViewById(R.id.total_price);
        }

        private void setTotalAmount(int totalItemText,String totalItemPriceText,String deliveryPriceText,String totalAmountText){
            totalItems.setText(totalItemText);
            totalItemPrice.setText(totalItemPriceText);
            deliveryPrice.setText(deliveryPriceText);
            totalAmount.setText(totalAmountText);
        }
    }
}
