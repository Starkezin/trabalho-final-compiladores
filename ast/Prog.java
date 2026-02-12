package ast;

import java.util.ArrayList;

public class Prog{
    public Main main;
    public ArrayList<Fun> fun;
    public Prog(Main main, ArrayList<Fun> fun)
    {
        this.main = main;
        this.fun = fun;
    }

    public String geraCodigo() {
        String codigo = "#include <stdio.h>\n#include <stdlib.h>\n\n";
        
        // Se tiver variáveis globais
        for (VarDecl v : fun.get(0).vars) {
            codigo += v.geraCodigo();
        }
        
        // Gera as funções
        for (Fun f : fun) {
            codigo += f.geraCodigo();
        }
        
        // Gera a main
        if (main != null) {
            codigo += main.geraCodigo();
        }
        
        return codigo;
    }
}

