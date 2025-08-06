package br.com.viniciussouza.spring_boot_rest_api.config;

public interface TestConfigs {
    int SERVER_PORT = 8888;
    String HEADER_PARAM_AUTHORIZATION = "Authorization";
    String HEADER_PARAM_ORIGIN = "Origin";

    String ORIGIN_DEV = "http://localhost:8888";
    String ORIGIN_DEV2 = "http://localhost:3000";
    String ORIGIN_INVALID_CORS = "http://localhost:4000";
}
