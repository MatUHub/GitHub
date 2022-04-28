package matUHub.github.data

import io.reactivex.rxjava3.core.Single
import matUHub.github.R
import matUHub.github.domain.GitProjectEntity
import matUHub.github.domain.ProjectsRepo

class MockProjectsRepoImpl: ProjectsRepo {
    override fun observeReposForUser(username: String): Single<List<GitProjectEntity>> {
        val dummyList = listOf(
            GitProjectEntity(1, "a", R.drawable.ic_item),
            GitProjectEntity(2, "б", R.drawable.ic_item),
            GitProjectEntity(3, "в", R.drawable.ic_item),
            GitProjectEntity(4, "г", R.drawable.ic_item),
        )
        return Single.just(dummyList)
    }

    override fun getRepoUsers(): Single<List<GitProjectEntity>> {
        val dummyList = listOf(
            GitProjectEntity(1, "James", R.drawable.ic_item),
            GitProjectEntity(2, "Geoffroy", R.drawable.ic_item),
            GitProjectEntity(3, "Amruth", R.drawable.ic_item),
            GitProjectEntity(4, "Jelle", R.drawable.ic_item),
        )
        return Single.just(dummyList)
    }

}