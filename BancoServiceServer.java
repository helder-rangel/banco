package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private List<Conta> contas;

    public BancoServiceServer() throws RemoteException {
        super();
        contas = new ArrayList<Conta>();
        contas.add(new Conta("1",100.00));
        contas.add(new Conta("2", 156.00));
        contas.add(new Conta("3", 950.00));
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        for(Conta cont : contas){
            if(cont.getNumero().equals(conta)){
                return cont.getSaldo();
            }
        }
        return 0.00;
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return contas.size();
    }

    @Override
    public void adicionarConta(String numero, double saldo) throws RemoteException {
        Conta conta = new Conta(numero,saldo);
        contas.add(conta);

    }

}
