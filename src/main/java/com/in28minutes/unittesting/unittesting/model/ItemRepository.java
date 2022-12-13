package com.in28minutes.unittesting.unittesting.model;

import org.springframework.data.jpa.repository.*;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
