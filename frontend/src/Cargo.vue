<template>
  <div id="app">
    <h1>Tela de gerenciamento de cargos</h1>

    <table>
        <thead>
            <tr>
                <td>Nome do cargo</td>
                <td>Ações</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="cargo in cargos" :key="cargo.nome">
                <td>{{cargo.nome}}</td>
                <td><a>Editar(Em construção)</a></td>
            </tr>
        </tbody>
    </table>

    <div id="cadastro-cargo-container">
        <input v-model="novoCargo" placeholder="Informe aqui o nome do novo cargo">
        <button @click="cadastrarNovoCargo">+ Cadastrar novo cargo</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Cargo',
  components: {  },
  mounted() {
      this.atualizarCargos()
  },

  data: function() {
      return {
          cargos: [],
          novoCargo: ""
      }
  },

  methods: {
        atualizarCargos() {
            axios.get("cargos").then(response => {
                this.cargos = response.data;
            })
        },

      cadastrarNovoCargo() {
          axios.post("cargos", { "nomeDoCargo": this.novoCargo }).then(response => {
              if(response.status == 200) {
                  alert(this.novoCargo + " Cadastrado com sucesso!")
              }
              this.atualizarCargos();
          })
      }
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1 {
    margin: 0 0 35px 0;
}

table {
    width: 100%;
    border: 1px solid black;
}

td {
    border: 1px solid black;
}

td a {
    cursor: pointer;
}

thead {
    font-weight: bold;
}

#cadastro-cargo-container {
    margin-top: 25px;
}

#cadastro-cargo-container input {
    width: 300px;
    height: 25px;
}

#cadastro-cargo-container button {
    background-color: cadetblue;
    color: white;
    border: 1px solid black;
    height: 30px;
    margin: 0 0 0 10px;
}
</style>
