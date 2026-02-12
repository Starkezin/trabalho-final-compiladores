package ast;

import java.util.ArrayList;

public class CIf extends Comando{
	public int linha;
	public Exp exp;
	public ArrayList<Comando> bloco;
	
	public CIf(int linha,Exp exp, ArrayList<Comando> bloco)
	{
	  this.linha = linha;
	  this.exp = exp;
	  this.bloco = bloco;
	} 

	@Override
	public String geraCodigo() {
		String codigo = "if (" + exp.geraCodigo() + ") {\n";
		
		for (Comando c : bloco) {
			codigo += c.geraCodigo();
		}
		
		codigo += "}\n";
		
		if (bloco != null && !bloco.isEmpty()) {
			codigo += "else {\n";
			for (Comando c : bloco) {
				codigo += c.geraCodigo();
			}
			codigo += "}\n";
		}
		
		return codigo;
	}

}
