<template>
  <div id="app">
    <h1>Tela de gerenciamento de perfis</h1>

    <table>
        <thead>
            <tr>
                <td>Nome do Perfil</td>
                <td>Ações</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="perfil in perfis" :key="perfil.nome">
                <td>{{perfil.nome}}</td>
                <td><a>Editar(Em construção)</a></td>
            </tr>
        </tbody>
    </table>

    <div id="cadastro-perfil-container">
        <input v-model="novoPerfil" placeholder="Informe aqui o nome do novo perfil">
        <button @click="cadastrarNovoPerfil">+ Cadastrar novo perfil</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: 'Perfil',
  components: {  },
  mounted() {
      this.atualizarPerfis()
  },

  data: function() {
      return {
          perfis: [],
          novoPerfil: ""
      }
  },

  methods: {
        atualizarPerfis() {
            axios.get("perfil").then(response => {
                this.perfis = response.data;
            })
        },

      cadastrarNovoPerfil() {
          axios.post("perfil", { "nomeDoPerfil": this.novoPerfil }).then(response => {
              if(response.status == 200) {
                  alert(this.novoPerfil + " Cadastrado com sucesso!")
              }
              this.atualizarPerfis();
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

#cadastro-perfil-container {
    margin-top: 25px;
}

#cadastro-perfil-container input {
    width: 300px;
    height: 25px;
}

#cadastro-perfil-container button {
    background-color: cadetblue;
    color: white;
    border: 1px solid black;
    height: 30px;
    margin: 0 0 0 10px;
}
</style>
