import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { first } from 'rxjs/operators';

@Component({
  selector: 'app-financing',
  templateUrl: './financing.component.html',
  styleUrls: ['./financing.component.css']
})
export class FinancingComponent implements OnInit {
  contryList!: any;
  loading = false;
  submitted = false;
  loading1 = false;
  submitted1 = false;
  loading2 = false;
  submitted2 = false;
  loginError: boolean = false;
  loginForm!: FormGroup;
  result: any =0;
  taxForm!: FormGroup;
  financingForm!: FormGroup;
  get f() { return this.loginForm.controls; }
  get t() { return this.taxForm.controls; }
  get Z() { return this.financingForm.controls; }
  constructor(private apiService: ApiService,
    private formBuilder: FormBuilder) { }


  ngOnInit(): void {

    this.loginForm = this.formBuilder.group({
      Nome: ['', Validators.required],
      cellphone: ['', Validators.required],
    });
    this.taxForm = this.formBuilder.group({
      Interno: ['4', Validators.required],
      Externo: ['6.5', Validators.required]
    });
    this.financingForm = this.formBuilder.group({
      Financiamneto: ['0', Validators.required],
      Meses: ['12', Validators.required],
      ValorDoVaiculo: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.loginForm.invalid) {
      return;
    }

    this.loading = true;
    this.apiService.postSaveClientFinancing(this.f.Nome.value, this.f.cellphone.value, this.result, this.Z.Meses.value)
      .pipe(first())
      .subscribe(
        data => { 
          this.loading = false;},
        error => {
          //this.alertService.error(error);
          this.loginError = true;
          this.loading = false;
        });
  }

  onSubmitTax() {
    this.submitted1 = true;

    // stop here if form is invalid
    if (this.taxForm.invalid) {
      return;
    }
    console.log(this.t.Interno.value/100)
    this.loading1 = true;
    this.apiService.PostFinancingValeu((this.t.Interno.value/100)+1, (this.t.Externo.value/100)+1)
      .pipe(first())
      .subscribe(
        data => {
          this.loading1 = false; },
        error => {
          this.loginError = true;
          this.loading1 = false;
        });

  }
  onSubmitFinancing() {

    this.submitted2 = true;

    // stop here if form is invalid
    if (this.financingForm.invalid) {
      return;
    }

    this.loading2 = true;
    this.apiService.postFinancingResult(this.Z.Meses.value, this.Z.ValorDoVaiculo.value, this.Z.Financiamneto.value)
      .pipe(first())
      .subscribe(
        data => {
          this.result = data;
          this.loading2 =false;
        },
        error => {
          this.loginError = true;
          this.loading = false;
        });

  }

}
