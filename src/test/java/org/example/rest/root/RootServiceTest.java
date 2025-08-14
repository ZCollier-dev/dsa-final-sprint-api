package org.example.rest.root;

import org.example.rest.node.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RootServiceTest {
    @Mock
    private RootRepo rootRepo;

    @InjectMocks
    private RootService rootService;

    private List<Double> sampleNumbers;

    @BeforeEach
    void setUp() {
        sampleNumbers = Arrays.asList(10.0, 5.0, 15.0);
    }

    @Test
    void getAllTrees_ShouldReturnListFromRepo() {
        List<Root> mockRoots = Collections.singletonList(new Root(new Node(), 1, sampleNumbers));
        when(rootRepo.findAll()).thenReturn(mockRoots);

        List<Root> result = rootService.getAllTrees();

        assertEquals(1, result.size());
        assertSame(mockRoots, result);
        verify(rootRepo).findAll();
    }

    @Test
    void createTreeFromList_ShouldReturnNull_WhenListIsEmpty() {
        assertNull(rootService.createTreeFromList(Collections.emptyList()));
        verifyNoInteractions(rootRepo);
    }

    @Test
    void createBalancedTreeFromList_ShouldCallSaveAndReturnRoot() {
        Node expectedNode = new Node();
        expectedNode.addNodeBalance(10.0);
        expectedNode.addNodeBalance(5.0);
        expectedNode.addNodeBalance(15.0);
        Root expectedRoot = new Root(expectedNode, 1, sampleNumbers);
        when(rootRepo.save(any(Root.class))).thenReturn(expectedRoot);

        Root result = rootService.createBalancedTreeFromList(sampleNumbers);

        assertNotNull(result);
        assertEquals(expectedRoot, result);
        verify(rootRepo).save(any(Root.class));
    }
}
