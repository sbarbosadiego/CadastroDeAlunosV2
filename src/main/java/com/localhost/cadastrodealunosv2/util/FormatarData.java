package com.localhost.cadastrodealunosv2.util;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Diego Barbosa da Silva
 */
public class FormatarData {
    
    static DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
    
    
    
}
