package com.parternship.locally.viewmodel

import android.widget.ImageView
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.parternship.locally.entity.User
import com.parternship.locally.repository.UserRepository
import de.hdodenhof.circleimageview.CircleImageView

class UserViewModel : ViewModel() {

  lateinit  var  name : ObservableField<String>
  lateinit var email : ObservableField<String>
  lateinit var image : ObservableField<CircleImageView>
  val userRepository :UserRepository = UserRepository()

  fun getAccountInfo() : Unit{
    var user =  userRepository.getUserDetails()
    name.set(user.value?.name)
  }


}