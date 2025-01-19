package com.example.cakeshop.dataroom

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.cakeshop.dataroom.UserRoom.UserEntity


@Dao
interface CartDao {
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
        tenND: String,
        email: String,
        sdt: String,
        username: String,
        trangThai: Int,
        chucVu: String
    ) {
        val user = UserEntity(
            MAND = MAND,
            tenND = tenND,
            email = email,
            sdt = sdt,
            TKNgD = TKNgD,
            TrangThai = TrangThai,
            ChucVu = ChucVu
        )
        insertUser(user)
    }


    @Delete
    suspend fun delete(user: NgDungEntity)
}