import { UserService } from './../../../../../services/user/user.service';
import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { takeUntilDestroyed } from '@angular/core/rxjs-interop';
import {
  FormControl,
  NonNullableFormBuilder,
  Validators,
} from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { merge } from 'rxjs';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrl: './user-registration.component.scss',
})
export class UserRegistrationComponent implements OnInit {
  form = this.formBuilder.group({
    document: ['', Validators.required],
    firstName: ['',Validators.required],
    lastName: ['',Validators.required],
    email: ['',Validators.required],
    password: ['', Validators.required],
    // creationDate: [new Date('2020-01-01')]
  });

  email = new FormControl('', [Validators.required, Validators.email]);

  errorMessage = '';
  hide = true;

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private snackBar: MatSnackBar,
    private location: Location,
    private userService: UserService
  ) {
    merge(this.email.statusChanges, this.email.valueChanges)
      .pipe(takeUntilDestroyed())
      .subscribe(() => this.updateErrorMessage());
  }

  updateErrorMessage() {
    if (this.email.hasError('required')) {
      this.errorMessage = 'You must enter a value';
    } else if (this.email.hasError('email')) {
      this.errorMessage = 'Not a valid email';
    } else {
      this.errorMessage = '';
    }
  }

  ngOnInit(): void {}

  onSubmit() {
    console.log(this.form.value);
    if (this.form.valid) {
      this.userService.save(this.form.value).subscribe(
        (result) => this.onSuccess(),
        (error) => this.onError()
      );
    }
  }

  onSuccess() {
    this.snackBar.open('Cadastro realizado com sucesso!', '', {
      duration: 5000,
    });
    this.onCancel();
  }

  onCancel() {
    this.location.back();
  }

  onError() {
    this.snackBar.open('Cadastro não realizado.', '', { duration: 5000 });
  }
}
