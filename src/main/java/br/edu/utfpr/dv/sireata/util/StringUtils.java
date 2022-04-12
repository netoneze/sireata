package br.edu.utfpr.dv.sireata.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.bouncycastle.jcajce.provider.digest.SHA3;
import org.bouncycastle.util.encoders.Hex;

import br.com.caelum.stella.inwords.InteiroSemFormato;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class StringUtils {

	public static String generateSHA3Hash(String s){
		SHA3.DigestSHA3 digestSHA3 = new SHA3.DigestSHA3(512);
	    byte[] digest = digestSHA3.digest(s.getBytes());

	    return Hex.toHexString(digest);
	}
	
	public static String getExtenso(int numero){
		NumericToWordsConverter converter;  
		converter = new NumericToWordsConverter(new InteiroSemFormato());
		return converter.toWords(numero);  
	}
	
	public static String getExtensoOrdinal(int numero, boolean feminino){
		String[] unidades = getUnidades();
		String[] dezenas = getDezenas();
		int unidade = (numero % 10), dezena = (numero / 10);
		String retorno = "";
		
		if(numero >= 100){
			return "N�mero muito grande";
		}
		
		if(dezena > 0){
			retorno = dezenas[dezena - 1] + (feminino ? "a " : "o ");
		}
		
		if(unidade > 0){
			retorno += unidades[unidade - 1] + (feminino ? "a " : "o ");
		}
		
		return retorno.trim();
 	}

	private static String[] getDezenas() {
		return new String[]{"d�cim", "vig�sim", "trig�sim", "quadrag�sim", "quinquag�sim", "sextag�sim", "septuag�sim", "octag�sim", "nonag�sim"};
	}

	private static String[] getUnidades() {
		return new String[]{"primeir", "segund", "terceir", "quart", "quint", "sext", "s�tim", "oitav", "non"};
	}

}
