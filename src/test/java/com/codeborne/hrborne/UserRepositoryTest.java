package com.codeborne.hrborne;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UserRepositoryTest {

    UserRepository repository = mock(UserRepository.class);

    @Test
    void getAllNames() {
        List<Name> nameList = new ArrayList<>();
        Name name = new Name(UUID.randomUUID(), "Jaanus", "Mendla");
        nameList.add(name);
        when(repository.getAllNames()).thenReturn(nameList);

        List<Name> result = repository.getAllNames();

        assertThat(result).isSameAs(nameList);
    }
}