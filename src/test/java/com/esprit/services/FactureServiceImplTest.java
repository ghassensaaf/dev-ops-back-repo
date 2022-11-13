package com.esprit.services;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;
import com.esprit.examen.services.FactureServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class FactureServiceImplTest {

    @Mock
    FactureRepository fr;

    @InjectMocks
    FactureServiceImpl fs;

    Facture f1 = new Facture(1L, 5, 55, new Date(), new Date(), false);
    Facture f2 = new Facture(2L, 6, 105, new Date(), new Date(), false);
    Facture f3 = new Facture(3L, 7, 205, new Date(), new Date(), true);
    Facture f4 = new Facture(4L, 25, 505, new Date(), new Date(), false);
    Facture f5 = new Facture(5L, 11, 320, new Date(), new Date(), false);

    List<Facture> listFactures = new ArrayList<Facture>() {
        {
            add(f1);
            add(f2);
            add(f3);
            add(f4);
        }
    };

    @Test
    public void testretrieveAllFactures() {
        Mockito.when(fr.findAll()).thenReturn(listFactures);
        List<Facture> listfac = fs.retrieveAllFactures();
        assertEquals(4, listfac.size());
    }

    @Test
    public void testaddProduit() {
        Mockito.when(fr.save(f1)).thenReturn(f1);
        fs.addFacture(f1);
        Mockito.verify(fr, times(1)).save(Mockito.any(Facture.class));
    }

    
    @Test
    public void testCancelFacturr() {
        Mockito.when(fr.save(f1)).thenReturn(f1);
        fs.cancelFacture(1L);
        Mockito.verify(fr, times(1)).save(Mockito.any(Facture.class));
    }
}
