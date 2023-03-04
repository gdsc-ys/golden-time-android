package com.next.goldentime.repository.user

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class UserStoreRepository(private val userStore: DataStore<Preferences>) : UserRepository {
    private val _user: Flow<User> =
        userStore.data.map { user ->
            val name = user[UserStore.Name.key] ?: ""
            val birthDate = user[UserStore.BirthDate.key] ?: ""
            val height = user[UserStore.Height.key] ?: 0.0
            val weight = user[UserStore.Weight.key] ?: 0.0
            val bloodType = user[UserStore.BloodType.key] ?: ""
            val allergies = user[UserStore.Allergies.key] ?: ""
            val medications = user[UserStore.Medications.key] ?: ""
            val medicalNotes = user[UserStore.MedicalNotes.key] ?: ""
            val diseases = (user[UserStore.Diseases.key] ?: "").split(",").map { it.toInt() }

            User(
                name,
                birthDate,
                height,
                weight,
                bloodType,
                allergies,
                medications,
                medicalNotes,
                diseases
            )
        }.flowOn(Dispatchers.IO)

    private val _name: Flow<String> =
        userStore.data.map { it[UserStore.Name.key] ?: "" }.flowOn(Dispatchers.IO)

    private val _diseases: Flow<List<Int>> =
        userStore.data.map {
            (it[UserStore.Diseases.key] ?: "").split(",").map { value -> value.toInt() }
        }.flowOn(Dispatchers.IO)

    override fun watchUser() = _user
    override fun watchName() = _name
    override fun watchDiseases() = _diseases

    override suspend fun setUser(user: User) {
        userStore.edit {
            it[UserStore.Name.key] = user.name
            it[UserStore.BirthDate.key] = user.birthDate
            it[UserStore.Height.key] = user.height
            it[UserStore.Weight.key] = user.weight
            it[UserStore.BloodType.key] = user.bloodType
            it[UserStore.Allergies.key] = user.allergies
            it[UserStore.Medications.key] = user.medications
            it[UserStore.MedicalNotes.key] = user.medicalNotes
            it[UserStore.Diseases.key] = user.diseases.joinToString(",")
        }
    }

    override suspend fun setDiseases(diseases: List<Int>) {
        userStore.edit {
            it[UserStore.Diseases.key] = diseases.joinToString(",")
        }
    }
}

val Context.userStore: DataStore<Preferences> by preferencesDataStore("user")

sealed class UserStore<T>(val key: Preferences.Key<T>) {
    object Name : UserStore<String>(stringPreferencesKey("name"))
    object BirthDate : UserStore<String>(stringPreferencesKey("birth_date"))
    object Height : UserStore<Double>(doublePreferencesKey("height"))
    object Weight : UserStore<Double>(doublePreferencesKey("weight"))
    object BloodType : UserStore<String>(stringPreferencesKey("blood_type"))
    object Allergies : UserStore<String>(stringPreferencesKey("allergies"))
    object Medications : UserStore<String>(stringPreferencesKey("medications"))
    object MedicalNotes : UserStore<String>(stringPreferencesKey("medical_notes"))
    object Diseases : UserStore<String>(stringPreferencesKey("diseases"))
}