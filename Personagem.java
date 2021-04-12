class Personagem{

    private int nivel = 1;
    private int xpTotal = 0;
    private int contadorXp = 0;
 
    private int manaAtual;
    private int manaMax;
    
    private int nvH0 = 0;
    private int nvH1 = 0;
    private int nvH2 = 0;
    private int nvH3 = 0;
 
    private int manaBaseH0;
    private int manaBaseH1;
    private int manaBaseH2;
    private int manaBaseH3;
    
    private int melhoriasDisponiveis = 1;

    public Personagem(int manaMax, int manaBaseH0, int manaBaseH1, int manaBaseH2, int manaBaseH3){
        this.manaMax = manaMax;
        this.manaAtual = manaMax;
        this.manaBaseH0 = manaBaseH0;
        this.manaBaseH1 = manaBaseH1;
        this.manaBaseH2 = manaBaseH2;
        this.manaBaseH3 = manaBaseH3;
    }

    public int getNivel(){
        return this.nivel;
    }

    public void adicionarXP(int valueXp){
        this.xpTotal += valueXp;
        this.contadorXp += valueXp;

        if(this.contadorXp >= 100){
            int result = contadorXp / 100;
            this.contadorXp -= 100 * result;
            
            if(this.nivel < 25){         
                
                this.melhoriasDisponiveis += result;

                this.nivel += result;
                if(this.nivel > 25){
                    this.nivel = 25;
                }                
            }
        }
    }
    
    public boolean melhorarHabilidade(int habilidade){

        boolean retorno = false;

        switch (habilidade){
            case 0:
                if(this.nvH0 < 4 && melhoriasDisponiveis > 0){
                    this.nvH0++;                    
                    retorno = true;
                }
            break;         
            
            case 1:
                if(this.nvH1 < 4 && melhoriasDisponiveis > 0){
                    this.nvH1++;                    
                    retorno = true;
                }
            break;   
            
            case 2:
                if(this.nvH2 < 4 && melhoriasDisponiveis > 0){
                    this.nvH2++;                    
                    retorno = true;
                }
            break;   

            case 3:                
                if(this.nivel >= 6){
                    if(this.nvH3 < 3 && melhoriasDisponiveis > 0){
                        this.nvH3++;                    
                        retorno = true;
                    }
                }
            break;   
        }        
        
        if(retorno){ this.melhoriasDisponiveis--; }
        return retorno;
    }    

    public boolean usarHabilidade (int habilidade){

        boolean retorno = false;

        switch (habilidade){
            case 0:
                if(nvH0 > 0){
                    int manaNecessaria1 = manaBaseH0 * nvH0;

                    if(manaNecessaria1 <= manaAtual){
                        manaAtual -= manaNecessaria1;
                        retorno = true;
                    }
                }
            break;         
            
            case 1:
                if(nvH1 > 0){
                    int manaNecessaria2 = manaBaseH1 * nvH1;
                    if(manaNecessaria2 <= manaAtual){
                        manaAtual -= manaNecessaria2;
                        retorno = true;
                    }
                }
            break;   
            
            case 2:
                if(nvH2 > 0){
                    int manaNecessaria3 = manaBaseH2 * nvH2;
                    if(manaNecessaria3 <= manaAtual){
                        manaAtual -= manaNecessaria3;
                        retorno = true;
                    }
                }
            break;   

            case 3:        
                if(nvH3 > 0){        
                    int manaNecessaria4 = manaBaseH3 * nvH3;
                    if(manaNecessaria4 <= manaAtual){
                        manaAtual -= manaNecessaria4;
                        retorno = true;
                    }
                }
            break;   
        }

        return retorno;
    }

    public void consumirPocao(){
        manaAtual += 350;
        if(manaAtual > manaMax){
            manaAtual = manaMax;
        }
    }
}