package com.example.bai2

import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Khai báo các thành phần UI
    private lateinit var editTextName: EditText
    private lateinit var buttonSave: Button
    private lateinit var textViewUserName: TextView
    private lateinit var buttonCancel: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Liên kết với layout activity_main.xml
        setContentView(R.layout.activity_main)

        // Khởi tạo các thành phần UI
        editTextName = findViewById(R.id.editTextName)
        buttonSave = findViewById(R.id.buttonSave)
        textViewUserName = findViewById(R.id.textViewUserName)
        buttonCancel = findViewById(R.id.buttonCancel)

        // Thiết lập sự kiện khi nhấn nút "Lưu"
        buttonSave.setOnClickListener {
            saveUserName()
        }

        // Thiết lập sự kiện khi nhấn nút "Hủy"
        buttonCancel.setOnClickListener {
            cancelInput()
        }
    }

    /**
     * Hàm lưu tên người dùng và hiển thị trong TextView
     */
    private fun saveUserName() {
        // Lấy tên từ EditText và loại bỏ khoảng trắng thừa
        val userName = editTextName.text.toString().trim()

        if (userName.isNotEmpty()) {
            // Đặt tên vào TextView
            textViewUserName.text = userName

            // Xóa nội dung trong EditText sau khi lưu
            editTextName.text.clear()

            // Ẩn bàn phím sau khi lưu
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(editTextName.windowToken, 0)

            // Hiển thị thông báo xác nhận
            Toast.makeText(this, "Tên đã được lưu", Toast.LENGTH_SHORT).show()
        } else {
            // Hiển thị lỗi nếu ô nhập liệu trống
            editTextName.error = "Vui lòng nhập tên người dùng"
        }
    }

    /**
     * Hàm xử lý khi nhấn nút "Hủy"
     * Xóa nội dung trong EditText và đặt lại TextView về mặc định
     */
    private fun cancelInput() {
        // Xóa nội dung trong EditText
        editTextName.text.clear()

        // Đặt lại TextView về giá trị mặc định
        textViewUserName.text = "Tên người dùng"

        // Ẩn bàn phím sau khi hủy
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(editTextName.windowToken, 0)

        // Hiển thị thông báo hủy
        Toast.makeText(this, "Đã hủy", Toast.LENGTH_SHORT).show()
    }
}