package com.example.surchat

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GroupChat : AppCompatActivity() {
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var messageInput: EditText
    private lateinit var sendButton: ImageButton
    private lateinit var microphoneButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_chat)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        messageInput = findViewById(R.id.message_input)
        sendButton = findViewById(R.id.send_button)
        microphoneButton = findViewById(R.id.microphone_button)

        chatAdapter = ChatAdapter(mutableListOf())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = chatAdapter

        messageInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s.isNullOrEmpty()) {
                    sendButton.visibility = ImageButton.GONE
                    microphoneButton.visibility = ImageButton.VISIBLE
                } else {
                    sendButton.visibility = ImageButton.VISIBLE
                    microphoneButton.visibility = ImageButton.GONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })

        sendButton.setOnClickListener {
            val text = messageInput.text.toString().trim()
            if (text.isNotEmpty()) {
                chatAdapter.addMessage(Message(text, true.toString()))
                messageInput.setText("")
            }
        }
    }

    private fun Message(username: String, text: String): Message {

        return TODO("Provide the return value")
    }
}
