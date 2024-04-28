package org.hse.template.repository

import org.hse.template.client.rest.model.CachedResponse
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CachedResponseRepository : JpaRepository<CachedResponse, String>