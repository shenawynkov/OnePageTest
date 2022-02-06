package com.shenawynkov.domain.usecases
import com.shenawynkov.domain.model.contact.ContactX
import com.shenawynkov.domain.repositories.ContactsRepo
import io.reactivex.Single
import javax.inject.Inject


class ContactsUseCase @Inject constructor(private val repo: ContactsRepo) {
    operator fun invoke(): Single<List<ContactX>> = repo.getContacts()

}