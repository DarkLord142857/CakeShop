package com.example.cakeshop.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.cakeshop.RoomDatabase.UserRoom.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user_item")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user_item WHERE MAND IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<UserEntity>

    @Insert
    fun insertUser(user: UserEntity)

    // Chèn từng phần tử (Không sử dụng @Insert mà viết một phương thức riêng)
    @Transaction
    suspend fun insertUserByFields(
        MAND: String,
        TenND: String,
        email: String,
        sdt: String,
        userName: String,
        trangThai: Int,
        chucVu: String
    ) {
        val user = UserEntity(
            MAND = MAND,
            tenND = TenND,
            email = email,
            sdt = sdt,
            userName = userName,
            trangThai = trangThai,
            chucVu = chucVu
        )
        insertUser(user)
    }


    @Delete
    suspend fun delete(user: UserEntity)
    @Update
    suspend fun  update(user: UserEntity)
}