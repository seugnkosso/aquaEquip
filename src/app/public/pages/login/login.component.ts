import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenResponse } from '../../../core/models/login.model';
import { RestResponse } from '../../../core/models/rest.response';
import { AuthentificateService } from '../../../core/services/auth/authentificate.service';
import { IdentifyService } from '../../../core/services/auth/identify.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  form = this.fb.group({
    username: '',
    password: '',
  });
  formInscrit = this.fb.group({
    nomComplet: '',
    email: '',
    telephone: '',
    username: '',
    password: '',
  });
  constructor(
    private fb: FormBuilder,
    private authService: AuthentificateService,
    private identifyS: IdentifyService,
    private router: Router
  ) {}

  ngOnInit(): void {}

  onSubmit() {
    let data = this.form.value;
    this.authService
      .login(data)
      .subscribe((res: RestResponse<TokenResponse>) => {
        if (res.status == 200) {
          localStorage.setItem('connecter', 'true');
          localStorage.setItem('token', res.results.token);
          localStorage.setItem('idUser', '' + res.results.id);
          localStorage.setItem(
            'role',
            this.identifyS.identified(res.results.roles)
          );
          if (res.results.roles.indexOf('Admin') != -1) {
            this.router.navigateByUrl('/admin/produit');
          }
          if (res.results.roles.indexOf('Client') != -1) {
            this.router.navigateByUrl('/public/accueil');
          }
        } else {
          console.log('Error');
        }
        //
      });
  }
  onSubmiInscrit() {
    const InscriptionClient = this.formInscrit.value;
    this.authService.inscritClient(InscriptionClient).subscribe((res) => {
      this.router.navigateByUrl('/public/accueil');
    });
  }
}
