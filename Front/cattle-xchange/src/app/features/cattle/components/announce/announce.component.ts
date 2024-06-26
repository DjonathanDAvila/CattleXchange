import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AdsService } from '../../../../services/ads/ads.service';
import { Breed } from '../../../../model/cattleAd/cattle/breed';
import { CattleAdInsertDTO } from '../../../../model/cattleAd/cattle/dtos/cattle-ad-insert-dto';
import { IbgeService } from '../../../../services/ibge/ibge.service';
import { Region } from '../../../../model/region/region';

@Component({
  selector: 'app-announce',
  templateUrl: './announce.component.html',
  styleUrls: ['./announce.component.scss'],
})
export class AnnounceComponent {
  form: FormGroup;
  breeds: Breed[] = [];
  regions: Region[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private adsService: AdsService,
    private snackBar: MatSnackBar,
    private router: Router,
    private ibgeService: IbgeService
  ) {
    this.form = this.formBuilder.group({
      title: ['', Validators.required],
      quantity: [null, [Validators.required, Validators.min(1)]],
      unitValue: [null, [Validators.required, Validators.min(0)]],
      description: ['', Validators.required],
      breed: ['', Validators.required],
      sex: ['', Validators.required],
      imageUrl: ['', Validators.required],
      region: ['', Validators.required],
    });
    this.getBreeds();
    this.getRegions();
  }

  annouce() {
    if (this.form.valid) {
      const form = this.form.value;
      const [city, state] = form.region.split(' - ');
      const adData: CattleAdInsertDTO = {
        title: form.title,
        desc: form.description,
        unitValue: form.unitValue,
        quantity: form.quantity,
        breed: form.breed,
        sex: form.sex,
        city: city,
        state: state,
        cattleAdImages: [{ sequence: 1, url: form.imageUrl }],
      };

      this.adsService.create(adData).subscribe({
        next: () => {
          this.snackBar.open('Anúncio criado com sucesso!', '', { duration: 7000 });
          this.router.navigate(['/operations/myAds']);
        },
        error: (err) => {
          this.snackBar.open(`Erro ao criar anúncio: ${err.message}`, '', { duration: 7000 });
        },
      });
    } else {
      this.snackBar.open('Por favor, preencha todos os campos obrigatórios.', '', { duration: 7000 });
    }
  }

  getBreeds() {
    this.breeds = [
      {
        breedName: 'Angus',
        imageUrl:
          'https://www.lancerural.com.br/wp-content/uploads/2021/06/ANGUS.jpg',
      },
      {
        breedName: 'Nelore',
        imageUrl:
          'https://semex.com.br/sites/default/files/styles/foto_touro_principal/public/corte/Gladiador-SITE0921.jpg?itok=Uo19uot9',
      },
      {
        breedName: 'Hereford',
        imageUrl:
          'https://upload.wikimedia.org/wikipedia/commons/c/cf/Hereford_bull_in_a_field_by_the_B4452_%28cropped%29.jpg',
      },
      {
        breedName: 'Limousin',
        imageUrl: 'https://www.cows.ie/custom/public/images/limousin.png',
      },
    ];
  }

  getRegions() {
    this.ibgeService.getRegions().subscribe({
      next: (regions) => {
        this.regions = regions;
      },
      error: (err) => {
        this.snackBar.open(`Erro ao carregar regiões: ${err.message}`, '', { duration: 7000 });
      },
    });
  }
}
