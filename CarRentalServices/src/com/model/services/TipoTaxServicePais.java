package com.model.services;

public enum TipoTaxServicePais {

	brazil {
		@Override
		public ITaxService obtertax() {
			// TODO Auto-generated method stub
			return new BrazilTaxService();
		}
	},
	usa{
		@Override
		public ITaxService obtertax() {
			// TODO Auto-generated method stub
			return new UsaTaxService();
		}
	};
	
	
	public abstract ITaxService obtertax();

}
