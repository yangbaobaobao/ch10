// Online Java Compiler (Editor)
// Write and run Java online using this editor.

class Main {
    public static void main(String[] args) {
        Fraction ethansCosmicness = new Fraction("8/32");
        ethansCosmicness = Fraction.add(ethansCosmicness, ethansCosmicness);
    }
}



class Fraction {
	private int numerator;
	private int denominator;
	
    public Fraction(String input) {
		int idx = input.indexOf("/");
		if (idx == -1) {
			System.out.println("INVALID SYNTAX: Input [numerator]/[denominator]");
			return;
		}
		numerator = Integer.parseInt(input.substring(0,input.indexOf("/")));
		denominator = Integer.parseInt(input.substring(input.indexOf("/")+1));
        System.out.println("Fraction created: " + numerator + "/" + denominator);
    }
    
    public Fraction(int num, int den) {
		numerator = num;
		denominator = den;
        System.out.println("Fraction created: " + numerator + "/" + denominator);
    }

    public Fraction(Fraction frac) {
		numerator = frac.getNum();
		denominator = frac.getDenom();
        System.out.println("Fraction created: " + numerator + "/" + denominator);
    }
    
    public Fraction() {
		numerator = 1;
		denominator = 1;
        System.out.println("Fraction created: " + 1 + "/" + 1);
    }

    public static Fraction add(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.getNum() * b.getDenom() + b.getNum() * a.getDenom(), a.getDenom() * b.getDenom());
        result.reduce();
        return result;
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.getNum() * b.getDenom() - b.getNum() * a.getDenom(), a.getDenom() * b.getDenom());
        result.reduce();
        return result;
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.getNum() * b.getNum(), a.getDenom() * b.getDenom());
        result.reduce();
        return result;
    }

    public static Fraction divide(Fraction a, Fraction b) {
        Fraction result = new Fraction(a.getNum() * b.getDenom(), a.getDenom() * b.getNum());
        result.reduce();
        return result;
    }
    
    public void reduce() {
		int num = 1;
		int den = -1;
		while (true){
            num = primeCheck(numerator);
    		den = primeCheck(denominator);
            //System.out.println(num + " | " + den);
            if (den == 1 || num == 1) break;
			numerator /= Math.max(num, den);
			denominator /= Math.max(num, den);
		}
		System.out.println("Fraction simplified into: " + numerator + "/" + denominator);
	}
	
	private int primeCheck(int n)
    {
        if (n <= 1)
            return 1;
        n = Math.abs(n);

        for (int i = 2; i <= n; i++)
            if (n % i == 0)
                return i;

        return 1;
	}

	public boolean equals(Fraction f) {
		return (f.reduce().toString().equals(this.reduce().toString());
	}
    
    public String toString() {
		return numerator + "/" + denominator;
	}
	
	public double toDouble() {
		return (double)numerator / denominator;
	}
    
    public int getNum() {
		return numerator;
	}
	
	public int getDenom() {
		return denominator;
	}

    public void setNum(int val) {
		numerator = val;
	}
	
	public void setDenom(int val) {
		denominator = val;
	}
}
