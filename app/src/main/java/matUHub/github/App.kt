package matUHub.github

import android.app.Application
import android.content.Context
import matUHub.github.data.MockProjectsRepoImpl
import matUHub.github.data.retrofit.RetrofitProjectsRepoImpl
import matUHub.github.domain.ProjectsRepo

class App: Application() {
    val gitProjectsRepo: ProjectsRepo by lazy { RetrofitProjectsRepoImpl() }
}

val Context.app: App
get() = applicationContext as App