package com.example.cakeshop.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.cakeshop.RoomDatabase.CartRoom.CartEntity
import com.example.cakeshop.RoomDatabase.UserRoom.UserEntity


@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items WHERE MaSp=:MaSp")
    suspend fun getCartItemById(MaSp: String): CartEntity?

    @Query("SELECT * FROM cart_items")
    suspend fun getAllCartItems(): List<CartEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartEntity)

    @Update
    suspend fun updateCartItem(cartItem: CartEntity)

    @Delete
    suspend fun deleteCartItem(cartItem: CartEntity)

    @Query("DELETE FROM cart_items")
    suspend fun deleteAllCartItems()
}