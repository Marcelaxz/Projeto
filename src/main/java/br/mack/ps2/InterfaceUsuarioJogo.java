package br.mack.ps2;

import br.mack.ps2.entidades.Jogo;
import br.mack.ps2.persistencia.JogoDAO;

import java.util.*;

public class InterfaceUsuarioJogo {
    JogoDAO dao;
    Scanner in;

    public InterfaceUsuarioJogo(JogoDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n======== Menu ========");
            System.out.println("\t1. Criar registro para Jogo");
            System.out.println("\t2. Consultar registro de Jogo");
            System.out.println("\t3. Atualizar registro de Jogo");
            System.out.println("\t4. Deletar Jogo");
            System.out.println("\t5. Sair");
            System.out.print("Escolha uma opção:_ ");
            opc = in.nextInt();

            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("Operação finalizada");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 5);
    }

    private void create() {
        Jogo jogo = new Jogo();

        System.out.println("\n--------- Novo registro para Jogo ---------");
        System.out.print("\nInforme o Nome do Primeiro Time: ");
        jogo.setNm_timeA(in.next());
        in.nextLine();

        System.out.print("\nInforme o Nome do Segundo Time: ");
        jogo.setNm_timeB(in.next());
        in.nextLine();

        System.out.print("\nInforme a Pontuação do Primeiro Time: ");
        jogo.setPont_timeA(in.nextInt());

        System.out.print("\nInforme a Pontuação do Segundo Time: ");
        jogo.setPont_timeB(in.nextInt());

        if (dao.create(jogo)) {
            System.out.println("Jogo adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar a Jogo");
        }
    }

    private void read() {
        List<Jogo> jogos = dao.read();

        System.out.println("\n--------- Lista de Jogos Cadastrados ---------");
        for(Jogo jogo : jogos) {
            System.out.println(jogo);
        }
    }

    public void update(){
        Jogo jogo = new Jogo();

        while(true){
            read();
            System.out.println("\nPara cancelar a operação, digite 1: ");
            int cnl = in.nextInt();
            if (cnl == 1) {
                break;
            }

            System.out.print("\nInforme o ID de Jogo registrado: ");
            jogo.setIdJogo(in.nextLong());
            in.nextLine();

            System.out.print("\nInforme o Nome do Primeiro Time: ");
            jogo.setNm_timeA(in.next());
            in.nextLine();

            System.out.print("\nInforme o Nome do Segundo Time: ");
            jogo.setNm_timeB(in.next());
            in.nextLine();

            System.out.print("\nInforme a Pontuação do Primeiro Time: ");
            jogo.setPont_timeA(in.nextInt());

            System.out.print("\nInforme a Pontuação do Segundo Time: ");
            jogo.setPont_timeB(in.nextInt());

            if (dao.update(jogo)) {
                System.out.println("\nJogo atualizado com sucesso!");
            } else {
                System.out.println("\nOcorreu um problema ao atualizar o Jogo");
            }
        }

    }

    private void delete() {
        List<Jogo> jogos = dao.read();

        while (true) {
            System.out.println("\n--------- Lista de Jogos Cadastrados ---------");
            int i = 0;
            for (Jogo jogo : jogos) {
                System.out.println(i + " - " + jogo);
                i++;
            }
            System.out.println(i + " - Cancelar Operação\n");

            System.out.print("Qual registro de Jogo deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc==i) {
                break;
            }

            if (opc >= jogos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(jogos.get(opc))) {
                    System.out.println("Jogo removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                break;
            }
        }
    }
}

