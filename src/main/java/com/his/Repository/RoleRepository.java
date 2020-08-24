package com.his.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.his.entity.RoleEntity;


public interface RoleRepository extends JpaRepository<RoleEntity,Serializable> {

}
