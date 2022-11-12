package com.esprit.services;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;
import tn.esprit.rh.achat.services.StockServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class OperateurServiceImplTest {


    @Mock
    OperateurRepository or;

    @InjectMocks
    OperateurServiceImpl os;

    Operateur o1 = new Operateur(1L,"moemen","trabelsi","test123");
    Operateur o2 = new Operateur(2L,"ahmed","fakhfakh","ahmed123");
    Operateur o3 = new Operateur(3L,"ghassen","saaf","ghassen123");

    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
        {
            add(o1);
            add(new Operateur(2L,"ahmed","fakhfakh","ahmed123"));
            add(new Operateur(3L,"ghassen","saaf","ghassen123"));
        }
    };

    @Test
    public void testretrieveAllOperateurs() {
        Mockito.when(or.findAll()).thenReturn(listOperateurs);
        List<Operateur> listOperateurs2 = os.retrieveAllProduits();
        assertEquals(3, listOperateurs2.size());
    }
}