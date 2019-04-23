package com.enums;

import com.entities.ICalculoImp;
import com.entities.PessoaFisica;
import com.entities.PessoaJuridica;

public enum TipoPlano {

	INDIVIDUAL {
		@Override
		public ICalculoImp obtercalculo() {
			// TODO Auto-generated method stub
			return new PessoaFisica();
		}
	},
	COMPANY {
		@Override
		public ICalculoImp obtercalculo() {
			// TODO Auto-generated method stub
			return new PessoaJuridica();
		}
	};

	public abstract ICalculoImp obtercalculo();

}
