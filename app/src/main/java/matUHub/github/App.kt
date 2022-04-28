package matUHub.github

import android.app.Application
import android.content.Context
import matUHub.github.data.MockProjectsRepoImpl
import matUHub.github.domain.ProjectsRepo

class App: Application() {
    val gitProjectsRepo: ProjectsRepo by lazy { MockProjectsRepoImpl() }
}

val Context.app: App
get() = applicationContext as App