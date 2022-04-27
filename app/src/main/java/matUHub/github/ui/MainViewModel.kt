package matUHub.github.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import matUHub.github.domain.GitProjectEntity

class MainViewModel: ViewModel() {
    private val

    private val _repos  = MutableLiveData<List<GitProjectEntity>>()
    val repos:LiveData<List<GitProjectEntity>> = _repos

    fun onShowRepos(userName: String){
        _echoMessage.postValue(userName)
    }
}