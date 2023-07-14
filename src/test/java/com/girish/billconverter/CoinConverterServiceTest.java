package com.girish.billconverter;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinConverterServiceTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Autowired
    private CoinConverterService coinConverterService;

    @Test
    public void testConvertToMinimumNumberOfCoins() {
        assertEquals(coinConverterService.convertToMinimumNumberOfCoins(40), 300);
        assertEquals(coinConverterService.convertToMinimumNumberOfCoins(1), 100);
        exception.expect(CoinConverterException.class);
        coinConverterService.convertToMinimumNumberOfCoins(1);
    }
}
