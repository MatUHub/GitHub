package matUHub.github.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy
import matUHub.github.domain.GitProjectEntity
import matUHub.github.domain.ProjectsRepo

class MainViewModel(private val gitProjectsRepo: ProjectsRepo) : ViewModel() {

    private val _repos = MutableLiveData<List<GitProjectEntity>>()
    val repos: LiveData<List<GitProjectEntity>> = _repos
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    /*fun onShowRepos(userName: String) {
        compositeDisposable.add(
            gitProjectsRepo.observeReposForUser(userName).subscribeBy {
                _repos.postValue(it)
            }
        )
    }*/

    fun showRepos(){
        compositeDisposable.add(
            gitProjectsRepo.getRepoUsers().subscribeBy {
                _repos.postValue(it)
            }
        )
    }

}