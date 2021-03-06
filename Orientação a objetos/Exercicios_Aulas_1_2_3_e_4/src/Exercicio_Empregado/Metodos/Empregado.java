package Exercicio_Empregado.Metodos;

import Exercicio_Empregado.Enums.TipoJornadaEmpregado;

public class Empregado extends Pessoa{
    //Atributos, vou usar o construtor default.
    private int codigoSetor;
    private float salarioBase;
    private float impostoRetido;
    private float salario;
    TipoJornadaEmpregado tipoJornadaEnum;

    //Construtor default
    public Empregado(){}


    //Construtor
    public Empregado(String nome, String endereco, String telefone, float salarioBase, float impostoRetido, int codigoSetor, TipoJornadaEmpregado tipoJornadaEnum){
        super(nome,endereco,telefone);
        this.salarioBase = salarioBase;
        this.impostoRetido = impostoRetido;
        this.codigoSetor = codigoSetor;
        this.tipoJornadaEnum = tipoJornadaEnum;
    }



    //Polimofismo de sobreposição, pois estou sobrepondo o toString da classe pessoa.
    @Override
    public String toString() {
        return "Empregado{" +
                "nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", telefone='" + getTelefone() + '\'' +
                ", salarioBase =' " + salarioBase + '\'' +
                ", impostoRetido =' " + impostoRetido + '\'' +
                ", codigoSetor ='" + codigoSetor + '\'' +
                ", tipoJornada ='" + tipoJornadaEnum + '\'' +
                '}';
    }

    //Getters
    public int getCodigoSetor() { return codigoSetor; }
    public float getSalarioBase() { return salarioBase; }
    public float getImpostoRetido() { return impostoRetido; }
    public float getSalario() {  return salario; }

    //Setters
    public void setCodigoSetor(int codigoSetor) { this.codigoSetor = codigoSetor; }
    public void setSalarioBase(float salarioBase) { this.salarioBase = salarioBase; }
    public void setImpostoRetido(float impostoRetido) { this.impostoRetido = impostoRetido; }
    public void setSalario(float salario) { this.salario = salario; }

    //Metodo para calcular salario
    //Não vi oportunidade de usar polimorfismo
    public void calcularSalario() {
        if (this.codigoSetor == 1) {
            this.salarioBase += ((this.salarioBase / 100) * 5);
            this.salario = this.salarioBase - ((this.salarioBase / 100) * this.impostoRetido);
        }
        if (this.codigoSetor == 2){
            this.salarioBase += ((this.salarioBase / 100) * 10);
            this.salario = this.salarioBase - ((this.salarioBase / 100) * this.impostoRetido);
        }
        if (this.codigoSetor == 3){
            this.salarioBase += ((this.salarioBase / 100) * 20);
            this.salario = this.salarioBase - ((this.salarioBase / 100) * this.impostoRetido);
        }
        if(this.codigoSetor < 1 || this.codigoSetor > 3){
            System.out.println("Codigo inválido, o salário será calculado sem acressimo");
            this.salario = this.salarioBase - ((this.salarioBase / 100) * this.impostoRetido);
        }
        System.out.println("O salario do empregado " + getNome() + " é: " + this.salario);
    }
}
