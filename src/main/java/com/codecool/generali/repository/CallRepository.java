package com.codecool.generali.repository;

import com.codecool.generali.model.Call;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CallRepository extends JpaRepository<Call, String> {

    List<Call> findAllByOrderByIdDesc();
}
