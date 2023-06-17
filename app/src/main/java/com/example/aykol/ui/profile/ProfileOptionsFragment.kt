package com.example.aykol.ui.profile

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.aykol.databinding.FragmentProfileOptionsBinding


class ProfileOptionsFragment : Fragment() {

    private lateinit var binding: FragmentProfileOptionsBinding
    private lateinit var launcher: ActivityResultLauncher<Intent>
    private lateinit var prefs: Prefs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileOptionsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLauncher()
        saveImage()
        saveSecondName()
        saveName()
        saveThirdName()
        saveGmail()
        click()
    }

    private fun saveImage() {
        binding.profileImage.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            launcher.launch(intent)
        }
    }

    private fun initLauncher() {
        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {

            if (it.resultCode == AppCompatActivity.RESULT_OK) {
                val image = it.data?.data
                if (image != null) {
                    binding.profileImage.setImageURI(image)

                }
            }
        }
    }

    private fun saveSecondName() {

        binding.et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                context?.let { Prefs(it).saveNames(s.toString()) }
            }
        })
        binding.et.setText(context?.let { Prefs(it).getName() })
    }

    private fun saveName() {

        binding.et2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                context?.let { Prefs(it).saveNames(s.toString()) }
            }
        })
        binding.et2.setText(context?.let { Prefs(it).getName() })
    }

    private fun saveThirdName() {

        binding.et3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                context?.let { Prefs(it).saveNames(s.toString()) }
            }
        })
        binding.et3.setText(context?.let { Prefs(it).getName() })
    }

    private fun saveGmail() {

        binding.email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                context?.let { Prefs(it).saveNames(s.toString()) };
            }
        })
        binding.email.text = context?.let { Prefs(it).getName() }
    }
    private fun click() {
        binding.tvChangePassword.setOnClickListener {
            findNavController()
        }
        binding.btnSave.setOnClickListener {
            //сохранить в преф
            findNavController().navigateUp()
        }
    }

}