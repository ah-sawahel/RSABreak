package t2;

import java.math.BigInteger;
import java.util.Arrays;

public class OldRSABreaker {

	private int n;
	private BigInteger e;
	private int encryptedMessage;
	
	public void setN(int n) {
		this.n = n;
	}
	
	public void setE(BigInteger e) {
		this.e = e;
	}
	
	private BigInteger getPhi() {
		Pair pair = sieve();
        return BigInteger.valueOf((pair.getP()-1)*(pair.getQ()-1));
    }

    public void setEncryptedMessage(int encryptedMessage) {
		this.encryptedMessage = encryptedMessage;
	}

	public BigInteger getD() {
		BigInteger b = getPhi();
		BigInteger e = this.e.add(new BigInteger("0"));
		BigInteger x = new BigInteger(0+"");
		BigInteger y = new BigInteger(1+"");
		BigInteger u = new BigInteger(1+"");
		BigInteger v = new BigInteger(0+"");
		while (!e.toString().equals("0")){
			BigInteger q = b.divide(e);
			BigInteger r = b.divideAndRemainder(e)[1];
			BigInteger m = x.subtract(u.multiply(q));
			BigInteger n = y.subtract(v.multiply(q));

			b = e;
			e = r;
			x = u;
			y = v;
			u = m;
			v = n;
		}
		return x;
	}
	
	public BigInteger decryptMessage() {
		//TO-DO
		return BigInteger.valueOf(encryptedMessage).modPow(getD(), BigInteger.valueOf(n));
	}
	
	private Pair sieve() {
		return generatePrimes(this.n);
	}


	private static Pair generatePrimes(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, 2, n + 1, true);
		for (int i = 2; i * i <= n; i++)
			if (prime[i])
				for (int j = i * i; j <= n; j += i)
					prime[j] = false;

		for (int i = 0; i < prime.length; i++)
			if (prime[i] && n%i == 0){
				int j = n/i;
				if(prime[j])
					return new Pair(i,j);
			}
		return null;
	}

	public static void main(String[] args) {
//		OldRSABreaker rsa = new OldRSABreaker();
//		rsa.setE(BigInteger.valueOf(5524331));
//		rsa.setN(1177662719);
//		Pair pairFound = rsa.sieve();
//		System.out.println(pairFound.toString());

		OldRSABreaker rsa = new OldRSABreaker();
		rsa.setE(BigInteger.valueOf(1787707));
		rsa.setN(2684839);
		rsa.setEncryptedMessage(1431820);
		System.out.println(rsa.getD());
		System.out.println(rsa.decryptMessage());

//		generatePrimes(1177662719);
	}
}