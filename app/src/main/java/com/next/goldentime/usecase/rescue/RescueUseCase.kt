package com.next.goldentime.usecase.rescue

import com.next.goldentime.repository.sos.Location
import com.next.goldentime.repository.sos.SOSRepository

class RescueUseCase(private val sosRepository: SOSRepository, private val sosId: Int) {
    fun getPatient() = sosRepository.getPatient(sosId)
    fun acceptSOS() = sosRepository.acceptSOS(sosId)
    fun postLocation(location: Location) = sosRepository.postLocation(sosId, location)
    fun markAsArrived() = sosRepository.markAsArrived(sosId)
    fun completeSOS() = sosRepository.completeSOS(sosId)
}