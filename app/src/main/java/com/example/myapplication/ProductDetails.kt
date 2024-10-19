package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
class ProductDetails : AppCompatActivity() {

    private lateinit var productTitle: TextView
    private lateinit var productPrice: TextView
    private lateinit var productImage: ImageView

    private val TAG = "ProductDetails"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        // Initialize views
        productTitle = findViewById(R.id.productTitle)
        productImage = findViewById(R.id.productImage)

        // Get product information from intent
        val product = intent.getParcelableExtra<products>("product")

        // Log the received product
        if (product != null) {
            Log.d(TAG, "Product received: $product")
            productTitle.text = product.name_product
            Glide.with(this)
                .load("http://192.168.2.22:3000${product.image_product}")
                .into(productImage)
        } else {
            Log.e(TAG, "No product data received")
            // Optionally, handle the case where the product is null
        }
    }
}

