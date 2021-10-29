<template>
  <div id="app">
    <h1>Tela de gerenciamento de Usuarios</h1>

    <table>
        <thead>
            <tr>
                <td>Nome do Usuario</td>
                <td>CPF</td>
                <td>Nascimento</td>
                <td>Sexo</td>
                <td>Cargo</td>
                <td>Perfis</td>
                <td>Data</td>
            </tr>
        </thead>
        <tbody>
            <tr v-for="usuario in usuarios" :key="usuario.nome">
                <td>{{usuario.nome}}</td>
                <td>{{usuario.cpf}}</td>
                <td>{{usuario.dataNascimento}}</td>
                <td>{{usuario.sexo}}</td>
                <td>{{usuario.cargo.nome}}</td>
                <td><span v-for="perfil in usuario.perfil" :key="perfil.nome">{{perfil.nome}} </span></td>
                <td><a>{{usuario.cadastro}}</a></td>
            </tr>
        </tbody>
    </table>

    <div id="cadastro-usuario-container">
        <input class="campo-texto" v-model="novoUsuario.nome" placeholder="Informe aqui o nome do novo usuario">
    </div>
    <div id="cadastro-usuario-container">
        <input class="campo-texto" v-model="novoUsuario.cpf" placeholder="Informe aqui o cpf do novo usuario">
    </div>
    <div id="cadastro-usuario-container">
        <input class="campo-texto" v-model="novoUsuario.dataNascimento" placeholder="Informe aqui a data de nascimento do novo usuario">
    </div>
    <div id="cadastro-usuario-container">
        <label for="sexo">Selecione um sexo: </label>
            <select name="sexo" id="sexo" v-model="novoUsuario.sexo">
                <option value="M">Masculino</option>
                <option value="F">Feminino</option>
            </select>
            <br><br>
    </div>
    <div id="cadastro-usuario-container">
        <label>Selecione os perfis desejados:</label>
        <ul>
            <li v-for="perfil in perfiss" :key="perfil.nome">
                <input type="checkbox" :id="perfil.nome" :name="perfil.nome" :value="perfil.nome" v-model="novoUsuario.perfil">
                <label :for="perfil.nome">{{perfil.nome}}</label>
            </li>       
        </ul>
    </div>
    <div id="cadastro-usuario-container">
        <label>Selecione o cargo: </label>
            <select name="cargo" id="cargo" v-model="novoUsuario.cargo">
                <option  v-for="cargo in cargoss" :key="cargo.nome" :value="cargo.nome">{{cargo.nome}}</option>
            </select>
    </div>
    <div id="cadastro-usuario-container">
        <button @click="cadastrarNovoUsuario">+ Cadastrar novo usuario</button>
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
      this.recuperarPerfis()
      this.recuperarCargo()
  },

  data: function() {
      return {
          cargoss: [],
          usuarios: [],
          novoUsuario: {
                nome: "",
                cpf: "",
                perfil: [],
                cargo: "",
                sexo: "",
                dataNascimento: ""
          },
          perfiss: [],
          perfisSelecionados: []
      }
  },

  methods: {

        recuperarPerfis() {
            axios.get("perfil").then(response => {
                this.perfiss = response.data;
            })
        },

        recuperarCargo() {
            axios.get("cargos").then(response => {
                this.cargoss = response.data;
            })
        },

        atualizarPerfis() {
            axios.get("usuarios").then(response => {
                this.usuarios = response.data;
            })
        },

        cadastrarNovoUsuario() {
            console.log(this.novoUsuario);    
            axios.post("usuarios", this.novoUsuario).then(response => {
              if(response.status == 200) {
                  alert(this.novoUsuario + " Cadastrado com sucesso!")
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

#cadastro-usuario-container {
    margin-top: 25px;
}

#cadastro-usuario-container .campo-texto {
    width: 300px;
    height: 25px;
}

#cadastro-usuario-container button {
    background-color: cadetblue;
    color: white;
    border: 1px solid black;
    height: 30px;
    margin: 0 0 0 10px;
}

ul {
    list-style: none;
    width: 300px;
    margin: 10px auto;
    text-align: left;
}

li {
    display: block;
}
</style>
