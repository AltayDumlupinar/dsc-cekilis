package com.example.cekilisuygulamasi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.TextView
import com.example.cekilisuygulamasi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var participantList = mutableListOf<Participant>()
    var winnerParticipant = Participant( fullName = "", dscName = "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.RollTheWNnerButton.setOnClickListener {rollTheWinner()}
        binding.AddPartCPantButton.setOnClickListener {addParticipant()}
    }

    fun addParticipant() {

        var fullNameString = binding.FullNameEditText.text.toString()
        var dscNameString = binding.DSCNameEditText.text.toString()

        if (TextUtils.isEmpty(fullNameString) || TextUtils.isEmpty(dscNameString)){
            binding.InfoText.text = "Add more participants before rolling."
        }
        else {
            val participant = Participant(fullNameString, dscNameString)
            participantList.add(participant)
            binding.InfoText.text = "${participant.fullName} added to list"
        }
        binding.FullNameEditText.text.clear()
        binding.DSCNameEditText.text.clear()
    }

    fun rollTheWinner() {
        if (participantList.count() == 0){
            binding.InfoText.text = "Add more participants before rolling."
        }
        else{
            winnerParticipant = participantList.random()
            binding.WinnerFullNameTextView.text = winnerParticipant.fullName
            binding.WinnerDSCNameTextView.text = winnerParticipant.dscName
        }

    }

    class Participant(val fullName : String, val dscName : String) {

    }

    }