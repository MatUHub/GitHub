package matUHub.github.domain

import io.reactivex.rxjava3.core.Single
import matUHub.github.domain.GitProjectEntity

interface ProjectsRepo {
    fun observeReposForUser(username: String): Single<GitProjectEntity>
}