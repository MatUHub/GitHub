package matUHub.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    private val _echoMessage = MutableLiveData<String>()
    val echoMessage: LiveData<String> = _echoMessage

    fun onShowRepos(userName: String){
        _echoMessage.postValue(userName)
    }
}